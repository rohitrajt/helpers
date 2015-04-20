DEFINE UPPER org.rohit.pig.udfs.UPPER();

data = LOAD 'src/test/resources/UPPER/names.txt' AS (names:CHARARRAY);

data_upper = FOREACH data GENERATE UPPER(*);

STORE data_upper INTO 'output';