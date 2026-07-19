@echo off
REM GitHub Push Script for RestAssured Project
REM This script automates pushing the project to GitHub

echo.
echo =========================================
echo   RestAssured Project - GitHub Push
echo =========================================
echo.

REM Ask for GitHub username
set /p GITHUB_USERNAME="Enter your GitHub username: "

if "%GITHUB_USERNAME%"=="" (
    echo Error: GitHub username is required!
    exit /b 1
)

REM Create the repository URL
set REPO_URL=https://github.com/%GITHUB_USERNAME%/RestAssured_Project.git

echo.
echo Repository URL: %REPO_URL%
echo.

REM Add remote
echo [1/3] Adding remote origin...
git remote add origin %REPO_URL%

REM Rename branch to main
echo [2/3] Renaming branch to main...
git branch -M main

REM Push to GitHub
echo [3/3] Pushing to GitHub...
git push -u origin main

if %ERRORLEVEL% EQU 0 (
    echo.
    echo =========================================
    echo   SUCCESS! Project pushed to GitHub
    echo =========================================
    echo.
    echo Repository: https://github.com/%GITHUB_USERNAME%/RestAssured_Project
    echo.
) else (
    echo.
    echo ERROR: Failed to push to GitHub
    echo Please check your credentials and try again.
    echo.
)

pause
