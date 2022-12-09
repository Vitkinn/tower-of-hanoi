package hanoitower.commom;

public class ArgumentsValidation {

    private static final String CONTIGUA = "CONTÍGUA";
    private static final String DINAMICA = "DINÂMICA";

    public static boolean validateArgumentsExistence(String[] arg) {
        try {
            if (!(arg != null
                    && !"".equals(arg[0])
                    && !"".equals(arg[1]))) {
                throw new RuntimeException("Por gentileza, informe um tipo de implementação e uma quantidade de discos.");
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Por gentileza, informe um tipo de implementação e uma quantidade de discos.");
        }
    }

    public static boolean validateFirstArgument(String arg) {
        if (!(arg != null
                && !"".equals(arg)
                && ((arg.toUpperCase()).equals(CONTIGUA)
                || (arg.toUpperCase()).equals(DINAMICA)))) {
            throw new RuntimeException("Por gentileza, informe um tipo de implementação (CONTÍGUA ou DINÂMICA).");
        }
        return true;
    }

    public static boolean validateSecondArgument(String arg) throws Exception {
        String exception;
        try {
            if (!(arg != null
                    && !"".equals(arg)
                    && Integer.valueOf(arg) >= 3)) {
                throw new RuntimeException("Por gentileza, informe um NÚMERO maior que 2 como segundo argumento.");
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Por gentileza, informe um NÚMERO maior que 2 como segundo argumento.");
        }
    }
}
