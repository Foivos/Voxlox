package com.foivos.voxlox.data;

public class Vector<T> {
	int length;
	T[] array;
	Vector(){
		array = new T[64];
		length = 0;
	}
	Vector(int size){
		array = new T[size];
		length = 0;
	}
}
