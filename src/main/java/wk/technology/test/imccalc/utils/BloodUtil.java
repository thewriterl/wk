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

    public static Boolean canReceiveFrom(String tipoSanguineo, String fromBloodType) {
         if (tipoSanguineo.contains("-")) {
             switch (tipoSanguineo) {
                 case "A-":
                     return fromBloodType.equals("A-") || fromBloodType.equals("O-");
                 case "B-":
                     return fromBloodType.equals("B-") || fromBloodType.equals("O-");
                 case "AB-":
                     return fromBloodType.equals("A-") || fromBloodType.equals("B-") || fromBloodType.equals("O-") || fromBloodType.equals("AB-");
                 case "O-":
                     return fromBloodType.equals("O-");
                 default:
                     throw new WKException(MensagemErro.ME_ERRO_AO_OBTER_ESTATISTICAS);
             }
         } else {
             switch (tipoSanguineo) {
                 case "A+":
                     return fromBloodType.equals("A-") || fromBloodType.equals("A+") || fromBloodType.equals("O-") || fromBloodType.equals("O+");
                 case "B+":
                     return fromBloodType.equals("B+") || fromBloodType.equals("B-") || fromBloodType.equals("O-") || fromBloodType.equals("O+");
                 case "AB+":
                     return true;
                 case "O+":
                     return fromBloodType.equals("O-") || fromBloodType.equals("O+");
                 default:
                     throw new WKException(MensagemErro.ME_ERRO_AO_OBTER_ESTATISTICAS);
             }
         }
    }

    public static Boolean canDonateTo(String tipoSanguineo, String toBloodType) {
        if (tipoSanguineo.contains("-")) {
            switch (tipoSanguineo) {
                case "A-":
                    return (toBloodType.equals("A+") || toBloodType.equals("A-") || toBloodType.equals("AB+") || toBloodType.equals("AB-"));
                case "B-":
                    return (toBloodType.equals("B+") || toBloodType.equals("B-") || toBloodType.equals("AB+") || toBloodType.equals("AB-"));
                case "O-":
                    return true;
                case "AB-":
                    return (toBloodType.equals("AB+") || toBloodType.equals("AB-"));
                default:
                    throw new WKException(MensagemErro.ME_ERRO_AO_OBTER_ESTATISTICAS);
            }
        } else {
            switch (tipoSanguineo) {
                case "A+":
                    return (toBloodType.equals("AB+") || toBloodType.equals("A+"));
                case "B+":
                    return (toBloodType.equals("B+") || toBloodType.equals("AB+"));
                case "O+":
                    return (toBloodType.equals("A+") || toBloodType.equals("B+") ||toBloodType.equals("AB+") ||  toBloodType.equals("O+"));
                case "AB+":
                    return  (toBloodType.equals("AB+"));
                default:
                    throw new WKException(MensagemErro.ME_ERRO_AO_OBTER_ESTATISTICAS);
            }
        }
    }

}
