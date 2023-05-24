package Library.domain

final case class Team(
                       id: Id,
                       name: Name,
                       points: Points = Points(0),
                       freeTransfers: Transfer = Transfer(2),
                     )
