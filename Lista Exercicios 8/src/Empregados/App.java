package Empregados;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        ArrayList<Empregado> empregados = new ArrayList<>();
        int opcao;
        int cont = 1;
        int funcionarioSelecionado = 0;
        while (true) {
            
            System.out.println( """
                    
                    1. Criar novo empregado
                    2. Listar Empregados
                    3. Selecionar Empregado
                    4. Promover empregado
                    5. Aumentar salário do empregado
                    6. Demitir empregado
                    7. Fazer aniversário do empregado
                    8. Mostrar detalhes dos empregados
                    9. Sair
            """);
            System.out.print("Insira a opçao desejada: ");
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Isira os dados do colaborador. ");
                    System.out.print("Nome: ");
                    input.nextLine();// limpar buffer.
                    String nome = input.nextLine();
                    System.out.print("Idade: ");
                    int idade = input.nextInt();
                    System.out.print("Salario: R$ ");
                    double salario = input.nextDouble();
                    int ID = cont;
                    empregados.add(new Empregado(nome, idade, salario, ID));
                    cont ++;
                    break;
                case 2:
                    for (Empregado empregado : empregados) {
                        System.out.println(empregado);
                    }
                    break;
                case 3:
                    System.out.print("Insira o ID do funcionario que deseja selecionaar: ");
                    int idDoFuncionarioSelecionado = input.nextInt();
                    if(IDvalidoBoolean(idDoFuncionarioSelecionado, empregados, funcionarioSelecionado)){
                        funcionarioSelecionado = IDvalidoInterger(idDoFuncionarioSelecionado, empregados, funcionarioSelecionado);
                    }else{
                        System.out.println("ID inválido.");
                    }
                    
                    break;
                case 4:
                    if(empregados.get(funcionarioSelecionado).promover(empregados.get(funcionarioSelecionado).getIdade(), empregados.get(funcionarioSelecionado).getSalario())){
                        empregados.get(funcionarioSelecionado).setSalario(empregados.get(funcionarioSelecionado).aumentarSalario(empregados.get(funcionarioSelecionado).getSalario(), 25));
                    }

                    ;
                    break;
                case 5:
                    System.out.println("Insira o valor aumento em porcentagem que o funcionrio ira receber:");
                    double percent = input.nextDouble();
                    empregados.get(funcionarioSelecionado).setSalario(empregados.get(funcionarioSelecionado).aumentarSalario(empregados.get(funcionarioSelecionado).getSalario(), percent));
                    System.out.printf("Seu novo salário é R$ %.2f \n",empregados.get(funcionarioSelecionado).getSalario());
                    
                    break;
                case 6:
                    System.out.println("""
                            Insira a opção desejada: 

                        1: Justa causa.
                        2: Decisão do empregador.
                        3: Aposentadoria.

                    """);
                    int opcaoMetodoDemitir = input.nextInt();
                    demitir(opcaoMetodoDemitir, empregados.get(funcionarioSelecionado).getSalario());
                    empregados.remove(funcionarioSelecionado);
                    break;
                case 7:
                    System.out.println("Parabéns você completou "+empregados.get(funcionarioSelecionado).fazerAniversario(empregados.get(funcionarioSelecionado).getIdade()));
                    empregados.get(funcionarioSelecionado).setIdade(empregados.get(funcionarioSelecionado).fazerAniversario(empregados.get(funcionarioSelecionado).getIdade()));
                    break;
                case 8:
                    System.out.println(empregados.get(funcionarioSelecionado));
                    break;
                case 9:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        
    }
    public static boolean IDvalidoBoolean(int idDoFuncionarioSelecionado, ArrayList<Empregado> empregados, int indexDoFuncionarioSelecionado){
        for (int i = 0; i < empregados.size(); i++){
            if(empregados.get(i).getID() == idDoFuncionarioSelecionado){
                indexDoFuncionarioSelecionado = i;
                return true;
        }
        }
        return false;
        }
    public static int IDvalidoInterger(int idDoFuncionarioSelecionado, ArrayList<Empregado> empregados, int indexDoFuncionarioSelecionado){
        for (int i = 0; i < empregados.size(); i++){
            if(empregados.get(i).getID() == idDoFuncionarioSelecionado){
                indexDoFuncionarioSelecionado = i;
                return indexDoFuncionarioSelecionado;
        }
        }
        return 0;
        }
    public static void demitir(int opcao, double salario){
        switch (opcao) {
            case 1:
                System.out.println("O funcionário deve cumprir o aviso prévio.");
                break;
            case 2:
                decisaoDoEmpregador(salario);
                break;
            case 3:
                aposentadoria(salario);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
    public static void decisaoDoEmpregador(double salario){
        System.out.printf("Sua recisão será no valor de %.2f",salario * 0.4); 
    }
    public static void aposentadoria(double salario){
        if(salario >= 1000 && salario <= 2000){
            System.out.println("O funcionário recebera R$ 1500,00 por mês de aposentadoria.");
        }else if (salario > 2000 && salario <= 3000) {
            System.out.println("O funcionário recebera R$ 2500,00 por mês de aposentadoria.");
        }else if (salario > 3000 && salario <= 4000){
            System.out.println("O funcionário recebera R$ 3500,00 por mês de aposentadoria.");
        }else if (salario > 4500){
            System.out.println("O funcionário recebera R$ 4000,00 por mês de aposentadoria.");
        }else{
            System.out.println("Salário inválido.");
        }
    }
}
