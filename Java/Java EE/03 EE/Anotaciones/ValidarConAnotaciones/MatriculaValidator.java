import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import Matricula;

public class MatriculaValidator implements ConstraintValidator<Matricula, String> {

  // ************ Matriculas de 1900-1971 *******************
  // ********************************************************

  // Expresiones regular para matriculas tipo [BI-51452, BI 51452, BI51452]
  private static final String EXP_BI_51452 = "[A-Z]{2}-[0-9]{5}|[A-Z]{2} [0-9]{5}|[A-Z]{2}[0-9]{5}";

  // Expresiones regular para matriculas tipo [L-62593, L 62593, L62593]
  private static final String EXP_L_62593 = "[A-Z]{1}-[0-9]{5}|[A-Z]{1} [0-9]{5}|[A-Z]{1}[0-9]{5}";

  // Expresiones regular para matriculas tipo [Z-103688, Z 103688, Z103688]
  private static final String EXP_Z_103688 = "[A-Z]{1}-[0-9]{6}|[A-Z]{1} [0-9]{6}|[A-Z]{1}[0-9]{6}";

  // *************** Matriculas de 1971-2000 ****************
  // ********************************************************

  // Expresiones regular para matriculas tipo [AB-1134-D, AB 1134 D, AB1134D]
  private static final String EXP_AB_1134_D = "[A-Z]{2}-[0-9]{4}-[A-Z]{1}|[A-Z]{2} [0-9]{4} [A-Z]{1}|[A-Z]{2}[0-9]{4}[A-Z]{1}";

  // Expresiones regular para matriculas tipo [B-9999-KT, B 9999 KT, B9999KT]
  private static final String EXP_B_9999_KT = "[A-Z]{1}[0-9]{4}[A-Z]{2}|[A-Z]{1} [0-9]{4} [A-Z]{2}|[A-Z]{1}-[0-9]{4}-[A-Z]{2}";

  // ************ Matriculas de 2000 en adelante ************
  // ********************************************************

  // Expresiones regular para matriculas tipo [9999-BBB, 9999 BBB, 9999BBB]
  private static final String EXP_9999_BBB = "[0-9]{4}-[A-Z]{3}|[0-9]{4} [A-Z]{3}|[0-9]{4}[A-Z]{3}";

  @Override
  public void initialize(final Matricula matricula) {

  }

  @Override
  public boolean isValid(final String value, final ConstraintValidatorContext constraintValidatorContext) {

    // Definir variable para validar
    Boolean isMatriculaValid = Boolean.FALSE;

    if (value != null) {
      // Validar matricula
      if (Pattern.matches(EXP_9999_BBB, value)) {
        isMatriculaValid = Boolean.TRUE;
      } else if (Pattern.matches(EXP_B_9999_KT, value)) {
        isMatriculaValid = Boolean.TRUE;
      } else if (Pattern.matches(EXP_AB_1134_D, value)) {
        isMatriculaValid = Boolean.TRUE;
      } else if (Pattern.matches(EXP_Z_103688, value)) {
        isMatriculaValid = Boolean.TRUE;
      } else if (Pattern.matches(EXP_L_62593, value)) {
        isMatriculaValid = Boolean.TRUE;
      } else if (Pattern.matches(EXP_BI_51452, value)) {
        isMatriculaValid = Boolean.TRUE;
      }
    }

    // Retornar resultado de la validacion
    return isMatriculaValid;
  }

}
