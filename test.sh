echo "testing 'Hello World'"
java -cp bin/ App

echo "testing 'Hello Nick' from args"
java -cp bin/ App -n Nick

echo "testing 'Hello Nick' from stdin"
echo 'Nick' | java -cp bin/ App -s
