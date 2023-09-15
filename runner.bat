@echo on

:: This script drives building of the MoneySaver kotlin program.
:: You will need to have kotlinc installed and java installed.

if "%~2"=="" (
    echo Usage: run.bat ^<path^> ^<command^> ^<max_size^> ^<extension^> ^<line_number^> ^<text_to_insert^> ^<test_to_find^>
    exit /b 1
)

:: Compile the Kotlin program
echo Compiling MoneySaver...
START /B /WAIT cmd /c "kotlinc *.kt -include-runtime -d main.jar"

:: Run the compiled program with the provided arguments
echo Running MoneySaver...
java -jar main.jar %1 %2 %3 %4 %5 "%~6" "%~7"