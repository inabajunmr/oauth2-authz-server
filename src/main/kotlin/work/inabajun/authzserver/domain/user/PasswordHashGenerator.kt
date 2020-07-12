package work.inabajun.authzserver.domain.user

import at.favre.lib.crypto.bcrypt.BCrypt

/**
 * Generate password hash
 */
class PasswordHashGenerator {

    companion object {

        /**
         * Compare law password and hashed password
         *
         * @param lawPassword original password send by user
         * @param hash persisted hashed password
         * @return if password matches hash, return true
         */
        fun equalsLawPasswordAndHash(lawPassword: String, hash: String): Boolean {
            return hash(lawPassword) == hash
        }

        /**
         * generate password hash for persistence
         *
         * @param lawPassword original password send by user
         */
        fun hash(lawPassword: String): String {
            // generate salt as random value
            val salt = bcrypt(lawPassword)
            var hash = ""

            for (i in 0..1000) {
                hash = bcrypt(hash + salt + lawPassword)
            }

            return hash
        }

        private fun bcrypt(value: String): String {
            return BCrypt.withDefaults().hashToString(12, value.toCharArray())
        }
    }
}
