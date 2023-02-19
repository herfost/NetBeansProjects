# CSVParser

Gli oggetti da convertire devono essere Java Bean, il primo attributo della classe deve essere il `serialVersionUID`, il file di lettura deve avere estensione `csv` e la prima riga deve contenere il degli attributi.



Snippet di esempio (Importare [CSVParser.jar](./dist/CSVParser.jar)): 
```java
    public static String path = "./x.csv"; // File esistente, la prima riga = "name;i\n"

    public static void main(String[] args) {
        X x = new X("aa", 10);
        try {
            CSVParser.writeObjectToCSV(X.class, x, path, ";");
        } catch (IOException | IllegalArgumentException | IllegalAccessException | InvalidFileTypeException ex) {
            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            List<Object> readFromCSV = CSVParser.readFromCSV(X.class, path, ";");

        } catch (IOException | NoSuchMethodException | ClassNotFoundException | UnmatchingFieldNameException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InvalidFileTypeException ex) {
            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static class X implements Serializable {

        private static final long serialVersionUID = 1L;
        String name;
        Integer i;

        public X() {
        }

        public X(String name, Integer i) {
            this.name = name;
            this.i = i;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getI() {
            return i;
        }

        public void setI(Integer i) {
            this.i = i;
        }

    }
```