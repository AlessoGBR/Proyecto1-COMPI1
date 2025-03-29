echo "INICIANDO COMPILADOR JFLEX"
java -jar /home/alesso/NetBeansProjects/Proyecto1-COMPI1/Back_COMPI1/src/main/resources/Recursos/flex/jflex-full-1.9.1.jar -d /home/alesso/NetBeansProjects/Proyecto1-COMPI1/Back_COMPI1/src/main/java/com/mycompany/back_compi1/Lexer/sHTTP /home/alesso/NetBeansProjects/Proyecto1-COMPI1/Back_COMPI1/src/main/java/com/mycompany/back_compi1/Lexer/sHTTP/sHTTPLexer.flex
echo "INICIANDO COMPILADOR CUP"
java -jar /home/alesso/NetBeansProjects/Proyecto1-COMPI1/Back_COMPI1/src/main/resources/Recursos/cup/cup-11a.jar -parser Parser -symbols ParserSym /home/alesso/NetBeansProjects/Proyecto1-COMPI1/Back_COMPI1/src/main/java/com/mycompany/back_compi1/Parsers/sHTTP/sHTTPParser.cup
mv Parser.java /home/alesso/NetBeansProjects/Proyecto1-COMPI1/Back_COMPI1/src/main/java/com/mycompany/back_compi1/Parsers/sHTTP/Parser.java
mv ParserSym.java /home/alesso/NetBeansProjects/Proyecto1-COMPI1/Back_COMPI1/src/main/java/com/mycompany/back_compi1/Parsers/sHTTP/ParserSym.java