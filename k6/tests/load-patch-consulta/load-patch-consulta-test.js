import http from 'k6/http';
import { check, sleep } from 'k6';

const url = 'http://localhost:8080/api/v1/medico/finalizar-consulta/144438';

export const options = {
  stages: [
    { duration: '1m', target: 300 }, // simulate ramp-up of traffic from 1 to 100 users over 5 minutes.
    { duration: '2m', target: 300 }, // stay at 100 users for 10 minutes
    { duration: '1m', target: 0 }, // ramp-down to 0 users
  ]
};

export default function () {
  let data = {
    status: "CANCELADA",
    exame: "exemplo finalizado",
    diagnostico: "exemplo finalizado",
    receita: "exemplo finalizado receita"
  }

  let res = http.patch(url, JSON.stringify(data), {
    headers: { 'Content-Type': 'application/json' },
  });

  check(res, { 'status was 200': (r) => r.status == 200 });
  sleep(1);
}
