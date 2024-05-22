package Empregados;

public class Empregado {
    private int ID;
    private String nome;
    private int idade;
    private double salario;

    public Empregado(String nome, int idade, double salario, int ID){
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.ID = ID;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public double getSalario(){
        return salario;
    }
    public void setSalario(double salario){
        this.salario = salario;
    }
    public void setId(int ID){
        this.ID = ID;
    }
    public int getID(){
        return ID;
    }
    public String toString(){
        return "ID :" + this.ID + "\n" 
                +"Nome: "+ this.nome + "\n"
                +"Idade: "+ this.idade +"\n"
                +"Salario: "+ this.salario +"\n";
    }
    public boolean promover(int idade, double salario){
        if(idade > 18){
            System.out.println("Parabens você foi promovido. seu novo salario é R$: "+ salario * 1.25);
            return true;
        }
        System.out.println("Infelizmente você não pode ser promovido. seu salario é R$: " + salario);
        return false;
    }
    public double aumentarSalario(double salario, double percent){
        
        double aumento = (1+ percent/100) * salario;
        return  aumento;
    }
   
    public int fazerAniversario(int idade){
        return idade + 1;
    }
}