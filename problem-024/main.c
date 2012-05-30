#include <stdio.h>
#include "problem024.h"

void print_array(char arr[], int size) {
    int i;
    for (i=0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main(void) {
    char arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int size = (int) sizeof(arr) / sizeof(arr[0]);

    problem024(arr, size, 1000000);
    print_array(arr, size);

    return 0;
}
