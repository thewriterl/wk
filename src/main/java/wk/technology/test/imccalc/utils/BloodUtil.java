package wk.technology.test.imccalc.utils;

import wk.technology.test.imccalc.domain.enums.MensagemErro;

import java.util.ArrayList;
import java.util.List;

public class BloodUtil {

//    public static List<String> canDonateTo(String tipoSanguineo, String toBloodType) {
//        switch (tipoSanguineo) {
//            case "A+":
//                List<String> avaiable = new ArrayList<String>();
//                avaiable.add("AB+");
//                avaiable.add("A+");
//                return ;
//        }
//    }

    public static Boolean canDonateTo(String tipoSanguineo, String toBloodType) {
        if (tipoSanguineo.contains("-")) {
            switch (tipoSanguineo) {
                case "A-":
                    if (toBloodType.equals("A+") || toBloodType.equals("A-") || toBloodType.equals("AB+") || toBloodType.equals("AB-"))
                    return true;
                case "B-":
                    if (toBloodType.equals("B+") || toBloodType.equals("B-") || toBloodType.equals("AB+") || toBloodType.equals("AB-"))
                    return true;
                case "O-":
                    return true;
                case "AB-":
                    if (toBloodType.equals("AB+") || toBloodType.equals("AB-"))
                    return true;
                default:
                    throw new WKException(MensagemErro.ME_ERRO_AO_OBTER_ESTATISTICAS);
            }
        } else {
            switch (tipoSanguineo) {
                case "A+":
                    if (toBloodType.equals("AB+") || toBloodType.equals("A+"))
                        return true;
                case "B+":
                    if (toBloodType.equals("B+") || toBloodType.equals("AB+") )
                        return true;
                case "O+":
                    if (toBloodType.equals("A+") || toBloodType.equals("B+") ||toBloodType.equals("AB+") ||  toBloodType.equals("O+"))
                        return true;
                case "AB+":
                    if (toBloodType.equals("AB+"))
                        return true;
                default:
                    throw new WKException(MensagemErro.ME_ERRO_AO_OBTER_ESTATISTICAS);
            }
        }
    }

}
