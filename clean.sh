#!/bin/sh
find * -name "*.class" > classes.txt
cat classes.txt | rm -rf
rm -rf classes.txt