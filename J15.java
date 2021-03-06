import java.util.*;
public class J15 extends Aux {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //BFS test
        int[] t_arr = new int[16];
        int[] t2_arr = new int[16];

        Tabela t_inicial = new Tabela(t_arr);
        Tabela t_final = new Tabela(t2_arr);

        scanTabelas(t_inicial, t_final);

        boolean init = testSolvability(t_inicial);
        boolean fin = testSolvability(t_final);
        if (init && fin) {
            System.out.print("\033[H\033[2J");
            //Runtime.getRuntime().exec("cls");
            System.out.printf("###################\n1.BFS\n2.DFS\n3.IDFS\n4.Greedy\n5.A*\n6.All\n\n");
            Scanner scan = new Scanner(System.in);
            boolean x = true;
            while(x){
            System.out.println("Option :");
            String option = scan.nextLine();
           
            switch (option) {

            case "1":
                System.out.printf("\n###################\n\n|__BFS__|\n");
                BFS(t_inicial, t_inicial.solution);
                x = false;
                break;

            case "2":
                System.out.printf("\n###################\n\n|__DFS__|\n");
                System.out.println("\nProfundidade utilizada : 80");
                System.out.println("\n##################\n\n");
                DFS(t_inicial, t_final.arr);
                x = false;
                break;

            case "3":
                System.out.printf("\n###################\n\n|__IDFS__|\n");
                IDFS(t_inicial, t_final);
                x = false;
                break;

            case "4":
                System.out.printf("\n###################\n\n|__Greedy__|\n");
                System.out.printf("###################\n1.Manhattan Distance\n2.Tile Sum\n");
                int option2 = scan.nextInt();
                if(option2 == 1)
                    greedy_Alg_Manhattan(t_inicial, t_inicial.solution);
                else greedy_Alg_TileSum(t_inicial, t_inicial.solution);
                x = false;
                break;

            case "5":
                System.out.printf("\n###################\n\n|__A*__|\n");
                System.out.printf("###################\n1.Manhattan Distance\n2.Tile Sum\n");
                option2 = scan.nextInt();
                if(option2== 1)
                a_star_M(t_inicial, t_inicial.solution);
            else 
                a_star_TS(t_inicial,t_inicial.solution);
                x = false;
                break;
            case "6":
                System.out.printf("\n###################\n\n|__BFS__|\n");
                BFS(t_inicial, t_inicial.solution);
                System.out.printf("\n###################\n\n|__DFS__|\n");
                DFS(t_inicial, t_final.arr);
                System.out.printf("\n###################\n\n|__IDFS__|\n");
                IDFS(t_inicial, t_final);
                System.out.printf("\n###################\n\n|__Greedy_Alg_Manhattan__|\n");
                greedy_Alg_Manhattan(t_inicial, t_inicial.solution);
                System.out.printf("\n###################\n\n|__Greedy_Alg_Sum_Tiles__|\n");
                greedy_Alg_TileSum(t_inicial, t_inicial.solution);
                System.out.printf("\n###################\n\n|__A*_Manhattan_|\n");
                a_star_M(t_inicial, t_inicial.solution);
                System.out.printf("\n###################\n\n|__A*_Tile_Sum_|\n");
                a_star_TS(t_inicial , t_inicial.solution);
                x = false;
                break;
            default:
            System.out.println("Por Favor insira uma opção válida");
            break;
            }
        }



        } else {
            if (!init)
                System.out.println("Invalid puzzle grid");

            else System.out.println("Invalid puzzle solution");
        }
    }
}
