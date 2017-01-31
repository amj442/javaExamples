#!/bin/bash

# strict error handling
set -o pipefail  # trace ERR through pipes
set -o errtrace  # trace ERR through 'time command' and other functions
set -o nounset   # set -u : exit the script if you try to use an uninitialised variable
set -o errexit   # set -e : exit the script if any statement returns a non-true return value

currentDir=`pwd`
echo "We now build all the examples of lesson 3 one by one in directory '$currentDir'."

find . -mindepth 2 -maxdepth 2 -name "make_linux.sh" -type f -execdir "{}" \;

echo "Successfully finished building the examples of lesson 3 in directory'$currentDir'."