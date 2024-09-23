package capitulo10;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class TesteCapitulo10 {

    public static void main(String[] args) {

        LocalDate mesQueVem = LocalDate.now().plusMonths(1);
        System.out.println(mesQueVem);

        LocalDate anoPassado = LocalDate.now().minusYears(1);
        System.out.println(anoPassado);

        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora);

        LocalTime horaAtual = LocalTime.now();
        System.out.println(horaAtual);


        ZoneId zoneId = ZoneId.of("UTC+5");
        System.out.println(zoneId);

        LocalDateTime agoraNoAcre = agora.atZone(zoneId).toLocalDateTime();
        System.out.println(agoraNoAcre);

        LocalDate dataNascimento = LocalDate.of(1994, 11, 21);
        System.out.println(dataNascimento);

        LocalTime horaNascimento = LocalTime.of(13, 5, 10);
        System.out.println(horaNascimento);

        var hoje = LocalDate.now();
        var amanha = LocalDate.now().plusDays(1);

        System.out.println(hoje.isBefore(amanha));
        System.out.println(hoje.isAfter(amanha));
        System.out.println(hoje.equals(amanha));

        int year = dataNascimento.getYear();
        Month month = dataNascimento.getMonth();
        int day = dataNascimento.getDayOfMonth();
        System.out.println(year);
        System.out.println(month.getValue());
        System.out.println(day);

        LocalDate dataNascimentoVenes = LocalDate.of(1993, Month.SEPTEMBER, 6);

        Locale pt = Locale.of("pt");
        System.out.println(Month.DECEMBER.getDisplayName(TextStyle.FULL, pt));

        String dataFormatada = dataNascimentoVenes.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(dataFormatada);

        String novoFormatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataNascimento);
        System.out.println(novoFormatoData);

        String dataHoraFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(LocalDateTime.now());
        System.out.println(dataHoraFormatada);


       var data1 = LocalDate.of(1994, 11, 21);
       var data2 = LocalDate.of(1993, 9, 6);

        long betweenDays = ChronoUnit.DAYS.between(data1, data2);
        long betweenMoth = ChronoUnit.MONTHS.between(data1, data2);
        long betweenYear = ChronoUnit.YEARS.between(data1, data2);
        System.out.println(betweenDays);
        System.out.println(betweenMoth);
        System.out.println(betweenYear);

        Period period = Period.between(data1, data2);

        if (period.isNegative()) {
            period = period.negated();
        }
        System.out.printf("%s dias, %s meses, %s anos", period.getDays(), period.getMonths(), period.getYears());

        System.out.println("");

        agora = LocalDateTime.now();
        LocalDateTime daquiAUmaHora = LocalDateTime.now().plusHours(1);
        Duration duration = Duration.between(agora, daquiAUmaHora);
        if (duration.isNegative()) {
            duration = duration.negated();
        }
        System.out.printf("%s horas, %s minutos e %s segundos",
                duration.toHours(), duration.toMinutes(), duration.getSeconds());
    }
}
