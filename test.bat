@echo off
for /f "delims=" %%a in ('where java') do set "JAVA_HOME=%%~dpsa"
echo %JAVA_HOME%
copy "hub.jar" "%JAVA_HOME%"
pause