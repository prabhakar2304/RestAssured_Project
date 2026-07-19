# GitHub Push Script for RestAssured Project
# Usage: ./push_to_github.ps1

Write-Host "==========================================" -ForegroundColor Cyan
Write-Host "  RestAssured Project - GitHub Push" -ForegroundColor Cyan
Write-Host "==========================================" -ForegroundColor Cyan
Write-Host ""

# Ask for GitHub username
$github_username = Read-Host "Enter your GitHub username"

if ([string]::IsNullOrWhiteSpace($github_username)) {
    Write-Host "Error: GitHub username is required!" -ForegroundColor Red
    exit 1
}

$repo_url = "https://github.com/$github_username/RestAssured_Project.git"

Write-Host ""
Write-Host "Repository URL: $repo_url" -ForegroundColor Yellow
Write-Host ""

# Step 1: Add remote
Write-Host "[1/3] Adding remote origin..." -ForegroundColor Yellow
git remote add origin $repo_url

if ($LASTEXITCODE -ne 0) {
    Write-Host "Note: Remote might already exist, attempting to update..." -ForegroundColor Yellow
    git remote set-url origin $repo_url
}

# Step 2: Rename branch to main
Write-Host "[2/3] Renaming branch to main..." -ForegroundColor Yellow
git branch -M main

# Step 3: Push to GitHub
Write-Host "[3/3] Pushing to GitHub..." -ForegroundColor Yellow
git push -u origin main

if ($LASTEXITCODE -eq 0) {
    Write-Host ""
    Write-Host "==========================================" -ForegroundColor Green
    Write-Host "  SUCCESS! Project pushed to GitHub" -ForegroundColor Green
    Write-Host "==========================================" -ForegroundColor Green
    Write-Host ""
    Write-Host "Repository: https://github.com/$github_username/RestAssured_Project" -ForegroundColor Green
    Write-Host ""
} else {
    Write-Host ""
    Write-Host "ERROR: Failed to push to GitHub" -ForegroundColor Red
    Write-Host "Please check your credentials and try again." -ForegroundColor Red
    Write-Host ""
}

# Keep window open
Read-Host "Press Enter to exit"
