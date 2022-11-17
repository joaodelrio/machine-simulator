/*
1 X (tipo da máquina [T/P/F])
2 I (estado inicial (número))
3 F1,F2,F3 (estados finais (número))
4 F,COND,T
5 ()
...
N () */



import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
public class Leitor {

    private String typeMachine;
    private String initialState;
    private String[] finalStates;
    private List<String[]> conditions = new ArrayList<String[]>();

    /* GETTER E SETTER */
    public String getTypeMachine() {
        return typeMachine;
    }
    public String getInitialState() {
        return initialState;
    }
    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }
    public String[] getFinalStates() {
        return finalStates;
    }
    public void setFinalStates(String[] finalStates) {
        this.finalStates = finalStates;
    }

    public List<String[]> getConditions() {
        return conditions;
    }
    public void setConditions(List<String[]> conditions) {
        this.conditions = conditions;
    }
    public void setTypeMachine(String typeMachine) {
        this.typeMachine = typeMachine;
    }


    /* FUNCOES */
    public void lerArquivo(String path) throws IOException{

        Path arquivo = Paths.get(path);
        if(!Files.exists(arquivo)){
            System.out.println("Não existe");
        }

        List<String> linhas = Files.readAllLines(arquivo);
    

        //X (tipo da máquina [T/P/F])
        setTypeMachine(linhas.get(0));

        //I (estado inicial (número))
        setInitialState(linhas.get(1));

        //F1,F2,F3 (estados finais (número))
       // System.out.println(linhas.get(2).split(","));
        setFinalStates(linhas.get(2).split(","));


        /*4 F,COND,T
        5 ()
        ...
        N () */
        List<String[]> aux = new ArrayList<String[]>();
        for(int i=3;i<=linhas.size()-1;i++){
            aux.add(linhas.get(i).split(","));
        }
        setConditions(aux);

    }


    public void escreverArquivo(String path, List<String> message) throws IOException{
        System.out.println("Gravando resultados em um arquivo...");
        Path arquivo = Paths.get(path);
        Files.write(arquivo, message);
        System.out.println("Gravado com Sucesso!");
    }

}

