@startuml

' hide the spot
hide circle

' avoid problems with angled crows feet
skinparam linetype ortho

entity "user" as user {
  *id : number <<generated>>
  --
  *name : text
  *email : text
  *phone : text
}

entity "client" as client {
  *client_id : number <<generated>>
  --
  *user_id : number <<FK>>
  *card_number : text
}

entity "driver" as driver {
  *driver_id : number <<generated>>
  --
  *user_id : number <<FK>>
}
entity "car" as car {
  *car_id : number <<generated>>
  --
  *driver_id : number <<FK>>
  *producer : text
  *model : text
  *registration_number : text
}
entity "order" as order {
  *order_id : number <<generated>>
  --
  *client_id : number <<FK>>
  *driver_id : number <<FK>>
  *start_location : text
  *destination_location : text
  *order_date : date
}

user ||..o| client
user ||..o| driver
driver||..o| car
driver||..|{order
client||..|{order

@enduml