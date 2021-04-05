(ns kotws.events (:require
                  [re-frame.core :as rf]
                  [kotws.db :as db]
                  [day8.re-frame.tracing :refer-macros [fn-traced]]))

(rf/reg-event-db ::initialize-db
                 (fn-traced [_ _]
                            db/default-db))

(rf/reg-event-db ::set-active-panel
                 (fn-traced [db [_ active-panel]]
                            (assoc db :active-panel active-panel)))

(rf/reg-event-db ::set-re-pressed-example
                 (fn-traced [db [_ value]]
                            (assoc db :re-pressed-example value)))

(rf/reg-event-db ::change-language
                 (fn-traced [db [_ language]]
                            (assoc
                             db :language language)))

(rf/reg-event-db ::change-slide-idx
                 (fn-traced [db [_ change-mode val]]
                            (case change-mode
                              :abs (assoc db :slide-idx val)
                              :rel (update db :slide-idx (partial + val))
                              )))

(rf/reg-event-db ::close-left-panel
                 (fn-traced [db _]
                            (assoc db :show-left-panel false)))

(rf/reg-event-db ::open-left-panel
                 (fn-traced [db _]
                            (assoc db :show-left-panel true)))

(rf/reg-event-db ::selected-items
                 (fn-traced [db [_ key]]
                            (update-in db [:selected-items]
                                       (fn [selected-items]
                                         (if (get selected-items key)
                                           (disj selected-items key)
                                           (conj selected-items key))))))
