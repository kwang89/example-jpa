### 데이터베이스를 중심으로 두고 설계한 Entity
- 객체 지향적으로 설계되지 않음
- 주문을 조회하면 회원 Id로 회원을 조회해야 회원 정보를 알 수 있음
  - 데이터베이스 중심으로 설계됨
- 이렇게 되면 주문을 조회한 회원 ID로 다시 조회해야함

### 객체 중심으로 설계해야함(참조 사용)
- 주문 entity에서 회원 entity를 참조하도록 설계 필요
- 주문 entity에 field로 회원 entity를 가지도록 해야함
- 주문 조회 후 getMember()를 통해 바로 회원데이터를 가지고 올 수 있음(객체 그래프 탐색)