(ns kotws.events
  "Record application level events."
  (:require [re-frame.core :as rf]
            [kotws.db :as db]))

(rf/reg-event-db ::initialize-db (fn [_ _] db/default-db))

(rf/reg-event-db ::set-active-panel
                 (fn [db [_ active-panel]]
                   (assoc db :active-panel active-panel)))

(rf/reg-event-db ::change-language
                 (fn [db [_ language]] (assoc db :language language)))

(rf/reg-event-db ::selected-items
                 (fn [db [_ key]]
                   (update-in db
                              [:selected-items]
                              (fn [selected-items]
                                (if (get selected-items key)
                                  (disj selected-items key)
                                  (conj selected-items key))))))
