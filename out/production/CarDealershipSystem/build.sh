export CLASSPATH=$CLASSPATH:"$PWD/forms_rt-7.0.3.jar" ; export CLASSPATH=$CLASSPATH:"$PWD/jgoodies-forms-1.6.0.jar"; export CLASSPATH=$CLASSPATH:"$PWD/swingx-1.6.1.jar";./clean.sh;find -name "*.java" > sources.txt; javac @sources.txt; rm sources.txt;