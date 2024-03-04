#!/bin/sh

if [ "$#" != 0 ] && [ "$#" != 1 ]; then
    echo "Usage: $0 <script>" >&2
    exit 1
fi

if [ "$#" == 0 ]; then
    cd ..
   echo "Executing script res/MultiLayer.txt...."
    rm res/pencil.jpg > /dev/null
    rm res/pencil.png > /dev/null
    rm res/penciloriginal.png > /dev/null
    java -jar res/Archive\ 2.jar res/MultiLayer.txt
   echo "Executing script res/MultiLayer2.txt...."
    rm res/pencil.jpg > /dev/null
    rm res/pencil.png > /dev/null
    rm res/penciloriginal.png > /dev/null
    java -jar res/Archive\ 2.jar res/MultiLayer2.txt
fi

if [ "$#" == 1 ]; then
    cd ..
   echo "Executing script res/$1..."
    rm res/pencil.jpg > /dev/null
    rm res/pencil.png > /dev/null
    rm res/penciloriginal.png > /dev/null
    java -jar res/Archive\ 2.jar res/"$1"
fi

exit 0
