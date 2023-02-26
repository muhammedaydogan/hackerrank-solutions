# cat input.txt | java -jar ArrayOfInt.jar > output.txt
rm *.class
javac Solution.java;
cat input.txt | java Solution > output.txt