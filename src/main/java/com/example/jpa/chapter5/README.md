### 객체 중심으로 설계해야함(참조 사용)
- 참조 방향에서 어떤 곳을 연관관계의 주인으로 정할지 잘 고려해야함
- A -> B : 다대일인 경우 A.getB(), B.getA() 이렇게 양방향으로 참조해야할 수 있음
- 이런 경우 A쪽에서 B에 대한 외래 키를 관리하므로 A를 연관관계 주인으로 설정하는게 좋음
- 즉 A의 B 필드에 @ManyToOne을 B의 A 필드에 @OneToMany와 함께 mappedBy를 설정필요
- 위 부분은 자료를 반복해서 읽어볼 것