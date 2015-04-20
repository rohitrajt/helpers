DEFINE UPPER org.rohit.pig.udfs.UPPER();

data = LOAD 'src/test/resources/UPPER/names.txt' AS (fullname:CHARARRAY);

data_upper = FOREACH data GENERATE UPPER(*);

STORE data_upper INTO 'src/test/resources/UPPER/output' USING AvroStorage('NameFile');