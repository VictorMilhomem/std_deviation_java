import java.util.Scanner;

public class standard_deviation
{
    public static void intro()
    {
        System.out.println("########################################## Calculo de Desvio Padrão ##########################################");
    }

    public static double[] standardDev(double[] values, int n)
    {
        double sum = 0;
        double std_dev, std_dev_sample, medium_value, average, population_variation, sample_population_var;

        for (int i = 0 ; i < n; i++)
        {
            sum += values[i];
        }
        medium_value = sum / 2;
        average = sum/n;

        // calculate std deviation
        double sum_value_average = 0;
        double sub_value_average_pow;

        for (int i = 0; i < n; i++)
        {
            sub_value_average_pow = Math.pow(values[i]-average, 2);
            sum_value_average += sub_value_average_pow;
        }

        std_dev = Math.sqrt(sum_value_average/n);
        population_variation = Math.pow(std_dev, 2);

        // sample deviation
        sum_value_average = 0;
        sub_value_average_pow = 0;

        for (int i = 0; i < n; i++)
        {
            sub_value_average_pow = Math.pow(values[i] - medium_value, 2);
            sum_value_average += sub_value_average_pow;
        }

        std_dev_sample = Math.sqrt(sum_value_average/(n-1));
        sample_population_var = Math.pow(std_dev_sample, 2);

        double stored_values[] = {medium_value, average, std_dev, population_variation, std_dev_sample, sample_population_var};
        return stored_values;
    }

    public static void run()
    {
        Scanner input = new Scanner(System.in);
        int n; boolean running = true; double val;
        double res[] = new double[6];

        while(running) {
            intro();
            System.out.println("Digite a quantidade de dados a serem inseridos:");
            n = input.nextInt();

            try{
                double values[] = new double[n];

                System.out.println("Digite os dados:");
                for (int i = 0; i < n; i++)
                {
                    val = input.nextDouble();
                    values[i] = val;
                }

                res = standardDev(values, n);

                System.out.printf("Valor médio da amostra: %2f\n", res[0]);
                System.out.printf("Media da amostra: %2f\n", res[1]);
                System.out.printf("Desvio Padrão: %2f\n", res[2]);
                System.out.printf("Variação da População: %2f\n", res[3]);
                System.out.printf("Desvio Padrão da amostra: %2f\n", res[4]);
                System.out.printf("Variação da População da amostra: %2f\n", res[5]);


                String contin;
                System.out.println("Deseja inserir novos dados? (s/n): ");
                contin = input.next();
                if (contin.equals("s") || contin.equals("sim") || contin.equals("Sim") || contin.equals("S"))
                    continue;
                else
                {
                    System.exit(1);
                }

            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Erro");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
