package Library.Json

import Library.domain
import Library.domain._
import io.circe.syntax.EncoderOps
import io.circe.{Decoder, Encoder, Json}

case object JsonLib {
  implicit val idDecoder: Decoder[Id] = cursor =>
    for {
      id <- cursor.get[Int]("id")
    } yield Id(id)

  implicit val idEncoder: Encoder[Id] = Encoder.instance {
    case Id(id) => Json.obj(
      "id" -> id.asJson,
    )
  }

  implicit val emailDecoder: Decoder[Email] = cursor =>
    for {
      email <- cursor.get[String]("email")
    } yield Email(email)

  implicit val emailEncoder: Encoder[Email] = Encoder.instance {
    case Email(email) => Json.obj(
      "email" -> email.asJson,
    )
  }

  implicit val userDecoder: Decoder[User] = cursor =>
    for {
      id <- cursor.get[Int]("id")
      userName <- cursor.get[String]("userName")
      email <- cursor.get[String]("email")
      password <- cursor.get[String]("password")
      access <- cursor.get[String]("access")
      budget <- cursor.get[Double]("budget")
    } yield User(Id(id), Name(userName), Email(email), Password(password), Access.withName(access), Budget(budget))

  implicit val userEncoder: Encoder[User] = Encoder.instance {
    case User(id, userName, email, password, access, budget) => Json.obj(
      "id" -> id.value.asJson,
      "userName" -> userName.value.asJson,
      "email" -> email.value.asJson,
      "password" -> password.value.asJson,
      "access" -> access.entryName.asJson,
      "budget" -> budget.value.asJson
    )
  }

  implicit val playerDecoder: Decoder[Player] = cursor =>
    for {
      id <- cursor.get[Int]("id")
      name <- cursor.get[String]("name")
      surname <- cursor.get[String]("surname")
      club <- cursor.get[String]("club")
      price <- cursor.get[Double]("price")
      position <- cursor.get[String]("position")
      status <- cursor.get[String]("status")
    } yield Player(
      Id(id),
      Name(name),
      Surname(surname),
      Club.withName(club),
      Price(price),
      Position.withName(position),
      Status.withName(status)
    )

  implicit val playerEncoder: Encoder[Player] = Encoder.instance {
    case Player(id, name, surname, club, price, position, status) => Json.obj(
      "id" -> id.value.asJson,
      "name" -> name.value.asJson,
      "surname" -> surname.value.asJson,
      "club" -> club.entryName.asJson,
      "price" -> price.value.asJson,
      "position" -> position.entryName.asJson,
      "status" -> status.entryName.asJson
    )
  }

  implicit val statDecoder: Decoder[Statistic] = cursor =>
    for {
      goals <- cursor.get[Int]("goals")
      assists <- cursor.get[Int]("assists")
      minutes <- cursor.get[Int]("minutes")
      ownGoals <- cursor.get[Int]("ownGoals")
      yellowCard <- cursor.get[Int]("yellowCards")
      redCard <- cursor.get[Int]("redCards")
      saves <- cursor.get[Int]("saves")
      cleanSheet <- cursor.get[Int]("cleanSheets")

    } yield Statistic(goals, assists, minutes, ownGoals, yellowCard, redCard, saves, cleanSheet)

  implicit val statEncoder: Encoder[Statistic] = Encoder.instance {
    case Statistic(goals, assists, minutes, ownGoals, yellowCard, redCard, saves, cleanSheet) => Json.obj(
      "goals" -> goals.asJson,
      "assists" -> assists.asJson,
      "minutes" -> minutes.asJson,
      "ownGoals" -> ownGoals.asJson,
      "yellowCards" -> yellowCard.asJson,
      "redCards" -> redCard.asJson,
      "saves" -> saves.asJson,
      "cleanSheets" -> cleanSheet.asJson
    )
  }

  implicit val userRegDecoder: Decoder[UserRegistration] = cursor =>
    for {
      userName <- cursor.get[String]("userName")
      email <- cursor.get[String]("email")
      password <- cursor.get[String]("password")
    } yield UserRegistration(Name(userName), Email(email), Password(password))

  implicit val userRegEncoder: Encoder[UserRegistration] = Encoder.instance {
    case UserRegistration(id, email, password) => Json.obj(
      "id" -> id.value.asJson,
      "email" -> email.value.asJson,
      "password" -> password.value.asJson
    )
  }

  implicit val userSignDecoder: Decoder[UserSignIn] = cursor =>
    for {
      email <- cursor.get[String]("email")
      password <- cursor.get[String]("password")
    } yield UserSignIn(Email(email), Password(password))

  implicit val UserSignEncoder: Encoder[UserSignIn] = Encoder.instance {
    case UserSignIn(email, password) => Json.obj(
      "email" -> email.value.asJson,
      "password" -> password.value.asJson
    )
  }

  implicit val teamCDecoder: Decoder[TeamCreation] = cursor =>
    for {
      name <- cursor.get[String]("name")
      players <- cursor.get[List[Id]]("players")
      captain <- cursor.get[Id]("captain")
    } yield domain.TeamCreation(Name(name), players, captain)

  implicit val teamCEncoder: Encoder[TeamCreation] = Encoder.instance {
    case TeamCreation(name, players, captain) => Json.obj(
      "name" -> name.value.asJson,
      "players" -> players.asJson,
      "captain" -> captain.asJson
    )
  }

  implicit val teamDecoder: Decoder[Team] = cursor =>
    for {
      id <- cursor.get[Int]("id")
      name <- cursor.get[String]("name")
      points <- cursor.get[Int]("points")
      transfers <- cursor.get[Int]("freeTransfers")
    } yield Team(Id(id), Name(name), Points(points), Transfer(transfers))

  implicit val teamEncoder: Encoder[Team] = Encoder.instance {
    case Team(id, name, points, transfers) => Json.obj(
      "id" -> id.value.asJson,
      "name" -> name.value.asJson,
      "points" -> points.value.asJson,
      "freeTransfers" -> transfers.value.asJson,
    )
  }
}