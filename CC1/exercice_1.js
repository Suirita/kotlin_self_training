let a = 10;

let b = { a };

b.a = 10;

function treatment(a, b) {
  a--;
  b.a--;
}
a--;
b.a--;
treatment(a, b);
console.log(a, b.a);
