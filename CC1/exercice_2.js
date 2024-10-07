function count_character(array, character) {
  let counter = 0;
  for (let i = 0; i < array.length; i++) {
    if (array[i] == character) {
      counter++;
    }
  }
  return counter;
}

console.log(count_character("hello", "l"));
