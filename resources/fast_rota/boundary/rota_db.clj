(ns fast-rota.boundary.rota-db
  (:require [integrant.core :as ig]))

(defprotocol RotaDb
  (rota-for-date [date]))

(defmethod ig/init-key :fast-rota.boundary/rota [_ db]
  )
