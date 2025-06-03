@echo off
REM ──────────────────────────────────────────────────────────
REM  git-auto.bat ‒ Commit y push interactivo
REM  Uso:      git-auto                (desde la carpeta del repo)
REM ──────────────────────────────────────────────────────────
SETLOCAL ENABLEDELAYEDEXPANSION

REM 1. Añadir todos los cambios al índice
git add -A

REM 2. Mostrar resumen de cambios
echo.
echo === Cambios a commitear ========================================
git status --short
echo.
echo === Diff resumido =============================================
git diff --cached --stat
echo.

REM 3. Solicitar mensaje de commit
set /p msg=Ingrese el mensaje de commit: 
if "%msg%"=="" (
    echo [ABORTADO] El mensaje no puede estar vacío.
    goto :eof
)

REM 4. Obtener el nombre de la rama actual
for /f "delims=" %%b in ('git rev-parse --abbrev-ref HEAD') do set branch=%%b

REM 5. Commit
git commit -m "%msg%"
if errorlevel 1 (
    echo [ERROR] No se pudo crear el commit.
    goto :eof
)

REM 6. Push
echo.
echo Haciendo push a origin/%branch% ...
git push origin %branch%
if errorlevel 1 (
    echo [ERROR] Falló el push.
    goto :eof
)

echo.
echo ==========================================================
echo ✔ Commit y push completados en la rama %branch%.
echo ==========================================================
ENDLOCAL
