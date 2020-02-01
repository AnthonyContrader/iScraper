package it.contrader.dto;

import java.sql.Date;

public class InjuryDTO {

		private int id;
		private int severity;
		private String description;
		private int duration;
		private Date date;
		private int player_id;
		
		
		
		public InjuryDTO(int id, int severity, String description, int duration, Date date, int player_id) {
			super();
			this.id = id;
			this.severity = severity;
			this.description = description;
			this.duration = duration;
			this.date = date;
			this.player_id = player_id;
		}
		
		public InjuryDTO(int severity, String description, int duration, Date date, int player_id) {
			super();
			this.severity = severity;
			this.description = description;
			this.duration = duration;
			this.date = date;
			this.player_id = player_id;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getSeverity() {
			return severity;
		}
		public void setSeverity(int severity) {
			this.severity = severity;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public int getPlayer_id() {
			return player_id;
		}
		public void setPlayer_id(int player_id) {
			this.player_id = player_id;
		}

		@Override
		public String toString() {
			return "Injury [id=" + id + ", severity=" + severity + ", description=" + description + ", duration=" + duration
					+ ", date=" + date + ", player_id=" + player_id + "]";
		}
}