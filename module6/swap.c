#include <stdio.h>

// Correct swap using pointers
void swap(int *a, int *b) {
    int temp;

    temp = *a;
    *a = *b;
    *b = temp;
}

void broken_swap(int a, int b) {
    int temp;

    temp = a;
    a = b;
    b = temp;

}

int main() {

    int x = 5;
    int y = 4;

    printf("=== Pointer Swap ===\n");

    printf("Before swap: x = %d, y = %d\n", x, y);

    swap(&x, &y);

    printf("After swap:  x = %d, y = %d\n", x, y);


    printf("\n=== Broken Swap ===\n");

    int a = 6;
    int b = 7;

    printf("Before broken_swap: a = %d, b = %d\n", a, b);

    broken_swap(a, b);

    printf("After broken_swap:  a = %d, b = %d\n", a, b);

    return 0;
}