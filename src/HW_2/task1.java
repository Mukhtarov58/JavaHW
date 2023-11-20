package HW_2;

public class task1 {
          public static StringBuilder answer(String QUERY, String PARAMS){
            StringBuilder whereClause = new StringBuilder();

            // Разбиваем строку параметров на отдельные пары ключ-значение
            String[] keyValuePairs = PARAMS.replaceAll("[{}\"]", "").split(",");

            // Перебираем все параметры и добавляем условия в запрос
            for (String pair : keyValuePairs) {
                String[] entry = pair.split(":");
                String key = entry[0].trim();
                String value = entry[1].trim();

                // Проверяем, что значение не равно "null"
                if (!"null".equals(value)) {
                    // Добавляем условие в запрос
                    whereClause.append(key).append("='").append(value).append("' and ");
                }
            }

            // Убираем лишний "AND " в конце строки
            if (whereClause.length() > 0) {
                whereClause.delete(whereClause.length() - 5, whereClause.length());
            }

            // Собираем итоговый запрос
            return new StringBuilder(QUERY).append(whereClause);
        }
    }


    // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
    class Printer2 {
        public static void main(String[] args) {
            String QUERY = "";
            String PARAMS = "";

            if (args.length == 0) {
                // При отправке кода на Выполнение, вы можете варьировать эти параметры
                QUERY = "select * from students where ";
                PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
            }
            else{
                QUERY = args[0];
                PARAMS = args[1];
            }

            task1 ans = new task1();
            System.out.println(ans.answer(QUERY, PARAMS));
        }
    }
