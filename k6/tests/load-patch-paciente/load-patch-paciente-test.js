import http from 'k6/http';
import { check, sleep } from 'k6';

const url = 'http://localhost:8080/api/v1/atendente/atualizar-paciente/76674423041';

export const options = {
  stages: [
    { duration: '1m', target: 300 }, // simulate ramp-up of traffic from 1 to 100 users over 5 minutes.
    { duration: '2m', target: 300 }, // stay at 100 users for 10 minutes
    { duration: '1m', target: 0 }, // ramp-down to 0 users
  ]
};

export default function () {
  let data = {
    nome: "test",
    dtNascimento: "12/04/1997",
    endereco: "test",
    telefone: "test",
    doencaCronica: "test"
  }

  let res = http.patch(url, JSON.stringify(data), {
    headers: { 'Content-Type': 'application/json' },
  });

  check(res, { 'status was 200': (r) => r.status == 200 });
  sleep(1);
}
