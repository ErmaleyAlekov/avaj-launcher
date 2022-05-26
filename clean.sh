#!/bin/sh
find * -name "*.class" > classes.txt
rm -rf $(cat classes.txt)
rm -rf classes.txt
rm -rf simulation.txt