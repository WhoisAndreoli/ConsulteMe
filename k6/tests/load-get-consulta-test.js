import http from 'k6/http';
import { check, sleep } from 'k6';

const url = 'http://localhost:8080/api/v1/atendente/buscar-consulta';

export const options = {
  stages: [
    { duration: '1m', target: 300 }, // simulate ramp-up of traffic from 1 to 100 users over 5 minutes.
    { duration: '2m', target: 300 }, // stay at 100 users for 10 minutes
    { duration: '1m', target: 0 }, // ramp-down to 0 users
  ]
};

export default function () {

  let res = http.get(url);
  check(res, { 'status was 200': (r) => r.status == 200 });
  sleep(1);
}
