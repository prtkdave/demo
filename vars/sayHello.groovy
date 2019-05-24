#!/usr/bin/env groovy

def call(String name = 'human') {
  echo "Hello, ${name}."
}
def newCall(String name){
  echo "Who am I, ${name}."
}

