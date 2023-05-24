package Library.domain

import Access.Base

final case class User(
                       id: Id,
                       userName: Name,
                       email: Email,
                       password: Password,
                       access: Access = Base,
                       budget: Budget = Budget(100.0)
                     )
