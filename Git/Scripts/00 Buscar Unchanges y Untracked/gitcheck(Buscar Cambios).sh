#!/bin/bash

## gitcheck:
##   Check all git repositories in subdirectories, and list the ones with changes

# Initialise counters:
let count_all=0
let count_changed=0
let count_unchanged=0

# Set to 1 for more verbose output:
let verbose=0

# Find git repos and loop over them:
for repo in `find . -type d -name ".git"`
do
    let count_all=${count_all}+1
    
    # cd to the dir that contains .git/:
    dir=`echo ${repo} | sed -e 's/\/.git/\//'`
    cd ${dir}
	
	text=$(git status)
	
	if git status | grep -q "Untracked"
	then
		echo -e "\n\n \E[1;31m ${dir}\E[0m"
		echo -e "\tUntracked"
		let count_changed=${count_changed}+1
		git ls-files . --exclude-standard --others
	fi
	
	if git status | grep -q "Changes not staged for commit"
	then
		echo -e "\n\n \E[1;31m ${dir}\E[0m"
		let count_changed=${count_changed}+1
		echo | git status | grep "modified:"
	fi
	
    # cd back:
    cd - &> /dev/null
done

# Report status and exit:
echo -ne "\n\n${count_all} git repositories found: "
echo -ne "${count_changed} have changes, "
echo -ne "${count_unchanged} are unchanged.\n\n"

read -n1 -r -p "Press space to continue..." key
