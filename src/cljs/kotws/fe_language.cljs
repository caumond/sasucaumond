(ns kotws.fe-language
  "Frontend language."
  (:require [kotws.subs :as subs]
            [kotws.local-storage :as klocal-storage]
            [kotws.events :as events]
            [re-frame.core :as rf]))

(defn current-language
  "Currently set language in the UI."
  []
  @(rf/subscribe [::subs/language]))

(defn set-language
  [l]
  (klocal-storage/set-item! :lang (name l))
  (rf/dispatch [::events/change-language l]))

(defn tr
  "Translate the key `k` based on `dic` entries.

  The `default` is used if not found, otherwise the key itself is shown (translated to string if is a keyword)."
  ([dic k] (tr dic k (if (keyword? k) (name k) k)))
  ([dic k default] (get-in dic [k (current-language)] default)))
