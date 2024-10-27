(ns kotws.subs
  "Global applications subscriptions."
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub ::name (fn [db] (:name db)))

(re-frame/reg-sub ::active-panel (fn [db _] (:active-panel db)))

(re-frame/reg-sub ::language (fn [db _] (:language db)))

(re-frame/reg-sub ::selected-items (fn [db _] (:selected-items db)))

