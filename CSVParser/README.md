# CSV Parser in Java usando java.lang.reflaction

## TODO:
- Gestire Serializable id;

## OSSERVAZIONI: 
- Utlizzando una mappe per associare nome - valore degli attributi
- Utlizzando metodi non statici, realizzando una classe non statica, instanziabile e generica, si aumenta l'astrazione della utility: invece che specificare nel metodo il tipo della classe e dell'oggetto, si specifica l'oggetto unicamente e il metodo, in modo autonomo, specifica la classe.