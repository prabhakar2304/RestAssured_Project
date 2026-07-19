# GitHub Push Instructions

## Step 1: Create Repository on GitHub

1. Go to https://github.com
2. Click "+" → "New repository"
3. Repository name: `RestAssured_Project`
4. Description: "REST API Testing with RestAssured and TestNG"
5. Choose Public/Private
6. Click "Create repository"

## Step 2: Push to GitHub

### Using HTTPS (Recommended for beginners)
```powershell
cd "C:\Users\pc\eclipse-workspace\RestAssured_Project"

# Add GitHub remote
git remote add origin https://github.com/YOUR_USERNAME/RestAssured_Project.git

# Rename branch to main
git branch -M main

# Push to GitHub
git push -u origin main
```

### Using SSH (More secure)
```powershell
git remote add origin git@github.com:YOUR_USERNAME/RestAssured_Project.git
git branch -M main
git push -u origin main
```

## Step 3: Verify on GitHub

1. Go to https://github.com/YOUR_USERNAME/RestAssured_Project
2. You should see all your files uploaded

## Common Commands After First Push

### Push new changes
```powershell
git add .
git commit -m "Your commit message"
git push
```

### Check status
```powershell
git status
```

### View commit history
```powershell
git log --oneline
```

### Clone the repository locally
```powershell
git clone https://github.com/YOUR_USERNAME/RestAssured_Project.git
```

## Troubleshooting

### If you get authentication errors:

**HTTPS (Token):**
1. Go to GitHub Settings → Developer settings → Personal access tokens
2. Generate a new token
3. Use the token as password when prompted

**SSH:**
1. Generate SSH key: `ssh-keygen -t ed25519 -C "your_email@example.com"`
2. Add public key to GitHub Settings → SSH keys
3. Test connection: `ssh -T git@github.com`

### Remove existing remote if added incorrectly:
```powershell
git remote remove origin
git remote add origin [correct-url]
```

## Need Help?

- GitHub Docs: https://docs.github.com
- Git Docs: https://git-scm.com/doc
